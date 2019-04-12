#include <deque>
#include <algorithm>
#include <iostream>
#include <iterator>
using namespace std;

int main()
{
    deque<int> Q; // pronounced "deck" - double-ended queue
    Q.push_back(3);
    copy(Q.begin(), Q.end(), ostream_iterator<int>(cout, " "));
    cout<<endl;
    Q.push_front(1);
    copy(Q.begin(), Q.end(), ostream_iterator<int>(cout, " "));
    cout<<endl;
    Q.insert(Q.begin() + 1, 2);
    copy(Q.begin(), Q.end(), ostream_iterator<int>(cout, " "));
    cout<<endl;
    Q[2] = 0;
    copy(Q.begin(), Q.end(), ostream_iterator<int>(cout, " "));
    // The values that are printed are 1 2 0
    cout <<endl;
    exit(0);
}
