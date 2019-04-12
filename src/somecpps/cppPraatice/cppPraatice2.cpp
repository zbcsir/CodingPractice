#include <stack>
#include <complex>
#include <iostream>
using namespace std;

int main() {
  stack<complex<int> > S; // the space between the '>' signs matters
  complex<int> a(1,2), b(4,7);
  S.push(a);
  S.push(b);
  S.push(a);
  S.pop();
  cout << "Top element is " <<  S.top()  <<endl;

  S.pop();
  S.pop();
  cout << "Number of elements is now " << S.size() <<endl;

  cout << "Stack empty? (1 means yes) " << S.empty() <<endl;
}
