#include<iostream>
using namespace std;
int peak(int arr[],int k){
int s=0;
               
                          int e=k-1;
                                                    int i;
                                                    int m=s+((e-s)/2);
                                                    while(s<e){
                                                        //using binary search
                                                       if(arr[m]<arr[m+1])
                                                        {s=m+1;
                                                    }
                                                         else                                                        {e=m;}
                                 
   
                                                        
                                                        m=s+((e-s)/2);
                                                       
                                                    }
        
  return s;  }


int main()
{int k;
cin>>k;//array size
    int arr[k];
for(int i=0;i<k;i++){
    cin>>arr[i];
}
cout<<peak(arr,k);

return 0;

}