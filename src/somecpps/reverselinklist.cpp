#include <iostream>
#include <algorithm>
#include <malloc.h>
#include <cstdlib>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head == NULL)
            return head;
        ListNode *p = head;
        ListNode *pre = NULL;
        ListNode *tmp = NULL;
        while(p->next != NULL){
            tmp = p->next;
            //cout<<p->val<<"**";
            p->next = pre;
            pre = p;
            p = tmp;
        }
        p->next = pre;
        return p;
    }

    bool hasCycle(ListNode *head) {
        //ListNode *slower = (struct ListNode *)malloc(sizeof(struct ListNode));
        //ListNode *faster = (struct ListNode *)malloc(sizeof(struct ListNode));
        ListNode *slower = head;
        ListNode *faster = head;
        bool res = false;
        while(faster != NULL && faster->next != NULL){
            slower = slower->next;
            faster = faster->next->next;
            cout<<"slower : "<<slower->val<<"  "<<"faster : "<<faster->val<<endl;
            if(slower == faster && slower != NULL){
                res = true;
                break;
            }

        }
        return res;
    }

    //合并两个有序列表
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *L = (struct ListNode *)malloc(sizeof(struct ListNode));
        ListNode *p1 = l1;
        ListNode *p2 = l2;
        if(l1 == NULL || l2 == NULL){
            if(l1 == NULL){
                return l2;
            }else{
                return l1;
            }
        }
        if(p1->val <= p2->val && p1 != NULL && p2 != NULL){
            L = l1;
            p1 = p1->next;
        }else if(p1->val > p2->val && p1 != NULL && p2 != NULL){
            L = l2;
            p2 = p2->next;
        }
        ListNode *p3 = L;
        while(p1 != NULL && p2 != NULL){
            if(p1->val <= p2->val){
                p3->next = p1;
                p3 = p3->next;
                p1 = p1->next;
            }else{
                p3->next = p2;
                p3 = p3->next;
                p2 = p2->next;
            }
        }
        while(p1 != NULL){
            p3->next = p1;
            p3 = p3->next;
            p1 = p1->next;
        }
        while(p2 != NULL){
            p3->next = p2;
            p3 = p3->next;
            p2 = p2->next;
        }
        p3->next = NULL;
        return L;
    }

    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(head == NULL){
            return head;
        }
        else if(head->next == NULL && n == 1){
            return head->next;
        }
        ListNode *p1 = head;
        ListNode *p2 = head;
        int i = 0;
        while(i < n){
            p1 = p1->next;
            ++i;
        }
        if(p1 == NULL){
            ListNode *q = head->next;
            head->val = q->val;
            head->next = q->next;
            free(q);
            return head;
        }else{
            while(p1->next != NULL){
                p1 = p1->next;
                p2 = p2->next;
            }
            ListNode *q = p2->next;
            p2->next = q->next;
            free(q);
        }
        return head;
    }

    ListNode* middleNode(ListNode* head) {
        ListNode *slower = head;
        ListNode *faster = head;
        while(faster != NULL && faster->next != NULL){
            faster = faster->next->next;
            slower = slower->next;
        }
        return slower;
    }

    void printList(ListNode* head){
        ListNode* p = head;
        while(p){
            cout<<p->val<<" ";
            p = p->next;
        }
        cout<<endl;
    }
};

int main(){

    struct ListNode *t1, *t2, *t3, *t4, *t5, *t6;
    //struct ListNode *t1;
    t1 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t2 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t3 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t4 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t5 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t6 = (struct ListNode *)malloc(sizeof(struct ListNode));
    //t1->val = 1;
    //t1->next = NULL;
    t1->val = 1;
    t1->next = t2;
    t2->val = 2;
    t2->next = t3;
    t3->val = 3;
    t3->next = t4;
    t4->val = 4;
    t4->next = t5;
    t5->val = 5;
    t5->next = t6;
    t6->val = 6;
    t6->next = NULL;
    /*
    struct ListNode *t1, *t2, *t3;
    struct ListNode *t4, *t5, *t6;
    t1 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t2 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t3 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t4 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t5 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t6 = (struct ListNode *)malloc(sizeof(struct ListNode));
    t1->val = 1;
    t1->next = t2;
    t2->val = 2;
    t2->next = t3;
    t3->val = 4;
    t3->next = NULL;

    t4->val = 1;
    t4->next = t5;
    t5->val = 3;
    t5->next = t6;
    t6->val = 4;
    t6->next = NULL;
    */

    Solution s;
    ListNode *r = (struct ListNode *)malloc(sizeof(struct ListNode));
    ListNode *m = (struct ListNode *)malloc(sizeof(struct ListNode));
    //m = s.mergeTwoLists(t1, t4);
    //r = s.removeNthFromEnd(t1,5);
    m = s.middleNode(t1);
    //bool res = s.hasCycle(t1);
    //cout<<res<<endl;
    s.printList(m);
    return 0;
}
