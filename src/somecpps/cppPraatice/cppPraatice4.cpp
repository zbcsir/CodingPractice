#include <vector>
#include <algorithm>
#include <functional>
#include <iostream>
#include <iterator>
using namespace std;

int main()
{
    int sum=0;
    vector<int> V;
    vector<int> T;
    V.push_back(1);
    V.push_back(4);
    V.push_back(2);
    V.push_back(8);
    V.push_back(5);
    V.push_back(7);

    copy(V.begin(), V.end(), ostream_iterator<int>(cout, " "));

    sum = count_if (V.begin(), V.end(), bind2nd(greater<int>(),5));
    cout << endl << "There are " << sum << " number(s) greater than 5" << endl;

    // "remove" all the elements less than 4
    vector<int>::iterator new_end =
            remove_if(V.begin(), V.end(), bind2nd(less<int>(), 4));

    // remove_if doesn't actually remove elements. It moves the unwanted
    // elements to the end and returns an iterator pointing to the first
    // of these unwanted elements. It works this way because
    // it's a generic routine and it doesn't "know" whether the size of
    // the underlying data structure can be changed.
    // But V.erase "knows" about vectors.
    V.erase(new_end, V.end());

    copy(V.begin(), V.end(), ostream_iterator<int>(cout, " "));
    cout << endl << "Elements less than 4 removed" << endl;

    sort(V.begin(), V.end());
    copy(V.begin(), V.end(), ostream_iterator<int>(cout, " "));
    cout << endl << "Elements sorted" << endl;
}
