#include <vector>
#include <algorithm>
#include <iostream>
#include <iterator>
using namespace std;

int square(int i) { return i * i; }

int main()
     {
     vector<int> V, V2;
     V.push_back(0);
     V.push_back(1);
     V.push_back(2);

     // transform all the elements of V, putting the answers back in V
     //transform(V.begin(),V.end(), V.begin(), square);

     // transform all the elements of V, putting the answers in V2
     transform(V.begin(), V.end(), back_inserter(V2), square);

     // Note that in C++11 and beyond you don't need a separate square
     // function. You can use
     // transform(V.begin(),V.end(), V.begin(), [] (int n) {return n*n;});

     //copy(V.begin(),V.end(), ostream_iterator<int>(cout, " "));
     copy(V2.begin(), V2.end(), ostream_iterator<int>(cout, " "));
     cout <<endl;
}
