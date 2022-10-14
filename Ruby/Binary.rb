def add(new_value)

  if @root == nil
    @root = Node.new(new_value)
    @total_nodes = 1
    return
  end

  current = @root
  while(true)
    if new_value <= current.value
      if current.right == nil
        current.right = Node.new(new_value)
        break
      else
        current = current.right
      end
    else
      if current.left == nil
        current.left = Node.new(new_value)
        break
      else
        current = current.left
      end
    end
  end

  @total_nodes += 1
end
