#include <iostream>  
using namespace std;  
class construct // create a class construct  
{  
public:  
    int a, b; // initialise two data members   
    construct() // this is how default constructor is created   
    {  
        // We can also assign both values to zero   
        a = 10; // intialise a with some value   
        b = 20; // initialise b with some value  
    }  
};  
int main()  
{     
    construct c; // creating an object of construct calls defualt constructor  
    cout<< "a:" <<c.a<<endl  
        << "b:" <<c.b; // print a and b   
    return 1;  
}  
