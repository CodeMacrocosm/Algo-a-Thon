#!/usr/bin/ruby   
  
$global_var = "GLOBAL"   
class One   
  def display   
     puts "Global variable in One is #$global_var"   
  end   
end   
class Two   
  def display   
     puts "Global variable in Two is #$global_var"   
  end   
end   
  
oneobj = One.new   
oneobj.display   
twoobj = Two.new   
twoobj.display  
