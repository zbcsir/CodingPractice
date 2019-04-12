#include <set>
#include <iostream>
#include <iterator>
#include <algorithm>
#include <string.h>
using namespace std;

int A[3]= {1, 2, 3};

set<int> setA(A, A+3);

int main1() {
    cout << setA.size() << " elements in the set" << endl;
    set<int>::iterator it1 = find(setA.begin(), setA.end(), 9);
    if (it1 == setA.end())
        cout << "9 not found\n";
    else
        cout << "9  found\n";
    setA.insert(9);
    cout << setA.size() << " elements in the set" << endl;
    it1 = find(setA.begin(), setA.end(),9);
    if (it1 == setA.end())
        cout << "9 not found\n";
    else
        cout << "9  found\n";
}

// define how the items are to be tested for equality
struct ltstr
{
    bool operator()(const char* s1, const char* s2) const
    {
        return strcmp(s1, s2) < 0;
    }
};

int main()
{
  const int N = 6;
  const char* a[N] = {"isomer", "ephemeral", "prosaic",
                      "nugatory", "artichoke", "serif"};
  const char* b[N] = {"flat", "this", "artichoke",
                      "frigate", "prosaic", "isomer"};

  set<const char*, ltstr> A(a, a + N);
  set<const char*, ltstr> B(b, b + N);
  //set<const char*, ltstr> C;

  cout << "Set A: ";
  copy(A.begin(), A.end(), ostream_iterator<const char*>(cout, " "));
  cout << endl;
  cout << "Set B: ";
  copy(B.begin(), B.end(), ostream_iterator<const char*>(cout, " "));
  cout << endl;

  cout << "Union: ";
  set_union(A.begin(), A.end(), B.begin(), B.end(),
            ostream_iterator<const char*>(cout, " "),
            ltstr());
  cout << endl;
  exit(0);
}
