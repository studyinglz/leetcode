/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflect;

/**
 *
 * @author liangzhang
 */
class Solution {
    public String longestPalindrome(String s) {
        String result="";
        int size=0;
        String reverse="";
        for (int i=0;i<s.length();i++)
        {
            reverse=s.charAt(i)+reverse;
        }
        char[] a=s.toCharArray();
        char[] b=reverse.toCharArray();
        boolean t=false;
        for (int i=1;i<a.length;i++)
        {
            if (a[i]!=a[i-1])
                t=true;
        }
        int count=0;
        if (!t)
        {
            for (int k=0;k<=1000000;k++) count++;
            return s;
        }
        for (int i=0;i<a.length;i++){
            for (int j=a.length-1;j>=i;j--)
            {
                boolean flag=false;
                for (int k=i;k<=j;k++)
                {
                    if (a[k]!=b[b.length-j-i+k-1])
                    {
                        flag=true;
                        break;
                    }
                }
                if (!flag){
                    if (j-i+1>size)
                    {
                        size=j-i+1;
                        result="";
                        for (int k=i;k<=j;k++)
                        {
                            result=result+a[k];
                        } 
                    }
                    break;
                } 
            }
            
        }
        return result;
    }
}}
