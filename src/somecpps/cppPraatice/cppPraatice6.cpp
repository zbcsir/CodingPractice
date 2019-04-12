#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>
#include <iterator>
using namespace std;

void print(int a){
    cout<<a<<',';
}

int main() {
  vector<int> V1(10), V2(10);
  fill(V1.begin(), V1.end(), 1);
  cout<<"====================fill==================="<<endl;
  for_each(V1.begin(), V1.end(), print);
  cout<<endl;

  partial_sum(V1.begin(), V1.end(),V1.begin() );
  cout<<"==================partial_sum================="<<endl;
  for_each(V1.begin(), V1.end(), print);
  cout<<endl;

  random_shuffle(V1.begin(), V1.end());

  fill(V2.begin(), V2.end(), 2);
  partial_sum(V2.begin(), V2.end(),V2.begin() );
  random_shuffle(V2.begin(), V2.end());
  cout<<"==================random_shuffle V1================="<<endl;
  copy(V1.begin(),V1.end(), ostream_iterator<int>(cout, " "));
  cout << endl;
  cout<<"==================random_shuffle V2================="<<endl;
  copy(V2.begin(),V2.end(), ostream_iterator<int>(cout, " "));
  cout<<endl;
  // transform all the elements of V1, using all the elements of V2
  // as operands, putting the answers in V2
  cout<<"==================transform================="<<endl;
  transform(V1.begin(), V1.end(), V2.begin(), V2.begin(), plus<int>());
  copy(V2.begin(),V2.end(), ostream_iterator<int>(cout, " "));
  cout <<endl;
}
