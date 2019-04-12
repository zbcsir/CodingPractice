#include <vector>
#include <list>
#include <algorithm>
#include <iostream>
#include <iterator>
using namespace std;

int main()
{
    vector<int> V;
    V.push_back(0);
    V.push_back(1);
    V.push_back(2);
    copy(V.begin(), V.end(), ostream_iterator<int>(cout, " "));
                    // Output: 0 1 2
    cout <<endl;
    list<int> L(V.size());
    reverse_copy(V.begin(), V.end(), L.begin());
    copy(L.begin(), L.end(), ostream_iterator<int>(cout, " "));
                    // Output: 2 1 0
    cout <<endl;

    vector<int> V2;
    //copy the elements from V that are not <1 into V2
    remove_copy_if(V.begin(), V.end(), back_inserter(V2),
                   bind2nd(less<int>(), 1));
    copy(V2.begin(), V2.end(), ostream_iterator<int>(cout, " "));
    cout <<endl;
    exit(0);
}
