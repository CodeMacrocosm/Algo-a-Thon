class MergeSort
  def sort(numbers)

    num_elements = numbers.length
    if num_elements <= 1
      return numbers
    end

    half_of_elements = (num_elements / 2).round

    left  = numbers.take(half_of_elements)
    right = numbers.drop(half_of_elements)

    sorted_left = sort(left)
    sorted_right = sort(right)

    merge(sorted_left, sorted_right)
  end

  def merge(left_array, right_array)
    if right_array.empty?
      return left_array
    end

    if left_array.empty?
      return right_array
    end

    smallest_number = if left_array.first <= right_array.first
      left_array.shift
    else
      right_array.shift
    end

    recursive = merge(left_array, right_array)

    [smallest_number].concat(recursive)
end
end
