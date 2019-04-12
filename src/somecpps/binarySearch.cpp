#include <iostream>
using namespace std;

// 查找最后一个值等于v的元素
int binarySearch2(int a[], int v, int n){
    int low = 0;
    int high = n-1;
    while(low <= high){
        int mid = low + ((high- low) >> 2);
        if(a[mid] < v){
            low = mid + 1;
        }else if(a[mid] > v){
            high = mid - 1;
        }else{
            if(a[mid+1] != v){
                return mid;
            }else{
                low = mid + 1;
            }
        }
    }
    return -1;
}

// 查找最后一个值小于等于v的元素
int binarySearch3(int a[], int v, int n){
    int low = 0;
    int high = n-1;
    while(low <= high){
        int mid = low + ((high - low) >> 2);
        if(a[mid] > v){
            high = mid -1;
        }else{
            if((mid == n-1) || (a[mid+1] > v)){
                return mid;
            }else{
                low = mid + 1;
            }
        }
    }
    return -1;
}

int main(){
    int a[7] = {3, 4, 5, 5, 7, 7, 10};
    int res = binarySearch3(a, 8, 7);
    cout<<res<<endl;
    return 0;
}
