#include <string>
#include <map>
#include <iostream>
#include <iterator>
using namespace std;

typedef multimap <string, string, less<string> > names_type;

 // Print out a pair
// Note: with gcc version 4.0.2 this needs to go onto the std namespace
namespace std {
    template <class First, class Second>
    ostream& operator<<(ostream& out,
                     const pair<First,Second>& p)
    {
        cout << p.first << " belongs to the " << p.second << " family";
        return out;
    }

    // Print out a multimap
    ostream& operator<<(ostream& out, names_type l)
    {
        copy(l.begin(),l.end(), ostream_iterator
                    <names_type::value_type>(cout,"\n"));
        return out;
    }
} // End of the namespace std insertion

int main()
{
    // create a multimap of names
    names_type names;
    typedef names_type::value_type value_type;

    // Put the names in the multimap
    names.insert(value_type(string("Sue"), string("Smith")));
    names.insert(value_type(string("Jane"), string("Smith")));
    names.insert(value_type(string("Kay"), string("Smith")));
    names.insert(value_type(string("Kurt"), string("Jones")));
    names.insert(value_type(string("Sue"), string("Jones")));
    names.insert(value_type(string("John"), string("Jones")));
    names.insert(value_type(string("Sophie"), string("Mackay")));
    names.insert(value_type(string("Steve"), string("Mackay")));
    names.insert(value_type(string("Sue"), string("Mackay")));

    // print out the names
    cout << "All the names" << endl << names << endl;
    // Find the people called Sue
    pair<names_type::iterator,names_type::iterator> p =
          names.equal_range("Sue");
    // print them out
    cout << endl << "People called Sue" << endl;
    copy(p.first,p.second,
        ostream_iterator<value_type>(cout,"\n"));

    return 0;
}
