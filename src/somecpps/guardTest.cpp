#include <iostream>
#include <stdio.h>

using namespace std;

// ������ a �У����� key������ key ���ڵ�λ��
// ���У�n ��ʾ���� a �ĳ���
int find1(char* a, int n, char key) {
  // �߽������������ a Ϊ�գ����� n<=0��˵��������û�����ݣ��Ͳ��� while ѭ���Ƚ���
  if(a == 0 || n <= 0) {
    return -1;
  }

  int i = 0;
  // �����������Ƚϲ�����i<n �� a[i]==key.
  while (i < n) {
    if (a[i] == key) {
      return i;
    }
    ++i;
  }

  return -1;
}


// ������ a �У����� key������ key ���ڵ�λ��
// ���У�n ��ʾ���� a �ĳ���
// �Ҿ� 2 �����ӣ��������������һ�´���
// a = {4, 2, 3, 5, 9, 6}  n=6 key = 7
// a = {4, 2, 3, 5, 9, 6}  n=6 key = 6
int find2(char* a, int n, char key) {
    if(a == 0 || n <= 0) {
        return -1;
    }

    // ������ΪҪ�� a[n-1] ��ֵ�滻�� key������Ҫ���⴦�����ֵ
    if (a[n-1] == key) {
        return n-1;
    }

    // �� a[n-1] ��ֵ��ʱ�����ڱ��� tmp �У��Ա�֮��ָ���tmp=6��
    // ֮������������Ŀ���ǣ�ϣ�� find() ���벻Ҫ�ı� a �����е�����
    char tmp = a[n-1];
    // �� key ��ֵ�ŵ� a[n-1] �У���ʱ a = {4, 2, 3, 5, 9, 7}
    a[n-1] = key;

    int i = 0;
    // while ѭ���������һ������ i<n ����Ƚϲ���
    while (a[i] != key) {
        ++i;
    }

    // �ָ� a[n-1] ԭ����ֵ, ��ʱ a= {4, 2, 3, 5, 9, 6}
    a[n-1] = tmp;

    if (i == n-1) {
        // ��� i == n-1 ˵������ 0...n-2 ֮�䶼û�� key�����Է��� -1
        return -1;
    } else {
        // ���򣬷��� i�����ǵ��� key ֵ��Ԫ�ص��±�
        return i;
    }
}


int main(){
    char a[6] = {4, 2, 3, 5, 9, 6};
    cout << find2(a, 6, 6)<<endl;
}
