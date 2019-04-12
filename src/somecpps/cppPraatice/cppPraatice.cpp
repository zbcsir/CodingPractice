#include <iostream>
#include <string>
#include <string.h>
#include <vector>
#include <algorithm>
using namespace std;

void print(vector<int> a){
    for(vector<int>::iterator it = a.begin(); it != a.end(); it++){
        cout<<*it<<'\t';
    }
    cout<<endl;
}

int main()
{
  string s;
  s="hello";
  s=s+" world";
  cout << s << endl;

  char s1[10];
  strcpy(s1,"hello");
  strcat(s1," world");
  cout <<  s1 << endl;

  vector<int> v(3); // Declare a vector of 3 ints
  v[0] = 7;
  v[1] = v[0] + 3;
  v[2] = v[0] + v[1];
  print(v);
  reverse(v.begin(), v.end());
  print(v);
  remove(v.begin()+1, v.end(), 10);
  print(v);

  string s2="spaces in text";
  cout << s2 << '\t'<< s2.size() << endl;
  s2.erase(remove(s2.begin(), s2.end(), ' ' ), s2.end() ) ;
  cout << s2 << '\t'<< s2.size() << endl;

}
