#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

bool multiple_of_three(int num) {return (num%3 == 0);}
void print_remainder(int num) {cout << num%3 << " ";}
int add1(int num) {return num+1;}

int main()
{
  // create a vector big enough to hold 10 ints
  vector<int> v(10);
  fill(v.begin(), v.end(), 1);
  partial_sum(v.begin(), v.end(),v.begin() );
  // v now contains 1....10

  // Use transform to change values
  transform(v.begin(), v.end(), v.begin(), add1);

  // Use for_each if you're not changing values
  cout << "Print remainders when dividing 2...11 by 3" << endl;
  for_each(v.begin(), v.end(), print_remainder);
  cout << endl;

  // Random shuffle
  random_shuffle(v.begin(), v.end());

  cout << "Remainders again, having shuffled" << endl;
  for_each(v.begin(), v.end(), print_remainder);
  cout << endl;

  // Use count_if to count how many elements have a particular property
  cout << count_if(v.begin(), v.end(), multiple_of_three)
       << " elements are a multiple of 3" << endl;
}
