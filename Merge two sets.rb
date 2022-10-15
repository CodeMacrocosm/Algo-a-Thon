=begin
Ruby program to merge two sets.
=end
require 'set'

Vegetable=Set.new(["potato","brocolli","broccoflower","lentils","peas","fennel","chilli","cabbage"])

Fruits = Set.new(["Apple","Mango","Banana","Orange","Grapes"])

Vegetable.each do |element|
    Fruits.add(element)
end

i = 1
Fruits.each do |element|
	puts "#{i} => #{element}"
	i = i + 1 
end
