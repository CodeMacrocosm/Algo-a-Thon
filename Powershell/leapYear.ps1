<#
    .SYNOPSIS
        Leap year calculation
    .PARAMETER years
        Integer list with years.
    .OUTPUTS
        String with result whether years are leap years
    .EXAMPLE
        .\leapYear.ps1 -years 2000, 2100, 2020, 2048, 1632, 2022
    .EXAMPLE
        .\leapYear.ps1 2000, 2100, 2020, 2048, 1632, 2022
    .EXAMPLE
        .\leapYear.ps1 2022
    .LINK
        https://github.com/CodeMacrocosm/Algoathon-22/blob/main/Powershell/leapYears.ps1
#>
param(
    [Parameter(Position=0, mandatory=$true)]
    [int[]]$years
)

# Set shell encoding
$OutputEncoding = [console]::InputEncoding = [console]::OutputEncoding = New-Object System.Text.UTF8Encoding

# json-String with output translations
$translations = @"
{
    "de-DE": {
        "true_now": "%year% ist ein Schaltjahr.",
        "false_now": "%year% ist kein Schaltjahr.",
        "true_past": "%year% war ein Schaltjahr.",
        "false_past": "%year% war kein Schaltjahr.",
        "true_future": "%year% wird ein Schaltjahr sein.",
        "false_future": "%year% wird kein Schaltjahr sein.",
        "pre1582": "%year% war vor der Kalenderreform."
    },
    "en-US": {
        "true_now": "%year% is a leap year.",
        "false_now": "%year% is not a leap year.",
        "true_past": "%year% was a leap year.",
        "false_past": "%year% was not a leap year.",
        "true_future": "%year% will be a leap year.",
        "false_future": "%year% will not be a leap year.",
        "pre1582": "The year %year% was before the calendar reform"
    },
    "fr-FR": {
        "true_now": "%year% est une année bissextile.",
        "false_now": "%year% n'est pas une année bissextile.",
        "true_past": "%year% était une année bissextile.",
        "false_past": "%year% n'était pas une année bissextile.",
        "true_future": "%year% sera une année bissextile.",
        "false_future": "%year% ne sera pas une année bissextile.",
        "pre1582": "L'année %year% était antérieure à la réforme du calendrie"
    }
}
"@

$tr = $translations | ConvertFrom-Json

# Identify or set CultureInfo for output translation
$CultureCode = (Get-UICulture).Name

if (!$tr.psobject.Properties.Name -contains $CultureCode) {
    $CultureCode = "en-US"
}

# The year of the calendar reform, from which leap years as we know them today were introduced
$yearReform = 1582

# The current year
$now = (Get-Date).Year

foreach ($year in $years) {
    # Recognise tense
    if ($year -lt $now) {
        $tense = "past"
    }
    elseif ($year -gt $now) {
        $tense = "future"
    }
    else {
        $tense = "now"
    }

    # Calculate leap year and output result
    if ($year -lt $yearReform) {
        Write-Output $tr.$CultureCode.pre1582.Replace("%year%", $year)
    }
    elseif ($year % 100 -eq 0 `
            -and !($year % 400) -eq 0) {
        Write-Output $tr.$CultureCode."false_$($tense)".Replace("%year%", $year)
    }
    elseif ((($year % 400) -eq 0) -or (($year % 4) -eq 0 -and !($year % 100) -eq 0)) {
        Write-Output $tr.$CultureCode."true_$($tense)".Replace("%year%", $year)
    }
    else {
        Write-Output $tr.$CultureCode."false_$($tense)".Replace("%year%", $year)
    }
}
