#include <iostream>
using namespace std:
int main()
{
  int rows;
  cout << "Ener number of rows:";
  cin >> rows;
  for(int i =1; i<=rows; ++i)
  {
    for (int j=1; j<=i; ++j){
      cout << "*";
    }
    cout << "\n";
  }
  return O;
}
