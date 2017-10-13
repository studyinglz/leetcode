/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflect;

import com.sun.xml.internal.ws.wsdl.writer.document.ParamType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author liangzhang
 */
public class MoreEfficientVersion {
    public static void main(String[] args)
    {

        String s="aaabbbaaa";
        char[] a=s.toCharArray();
        char[] b=new char[a.length*2+1];
        for (int i=0;i<a.length;i++)
        {
            b[2*i]=33;
            b[2*i+1]=a[i];
        }
        b[2*a.length]=33;
        int pos=0;
        int mx=0;
        int[] pr=new int[b.length];
        for (int k=0;k<b.length;k++){
            if (k<mx)
            {
                    pr[k]=pr[2*pos-k]>mx-k?mx-k:pr[2*pos-k];
                    int v=pr[k];
                    while ((k-v)>=0&& (k-v<b.length)&&(k+v>=0) && (k+v<b.length) &&b[k+v]==b[k-v])
                        v++;
                    pr[k]=v-1;
                    if (pr[k]>pr[pos])
                    {
                        pos=k;
                        mx=pr[k]+k;
                    }
                
            }
            else
            {
                pr[k]=1;
                int v=pr[k];
                while ((k-v)>=0&& (k-v<b.length)&&(k+v>=0) && (k+v<b.length) &&b[k+v]==b[k-v])
                    v++;
                pr[k]=v-1;
                if (pr[k]>pr[pos])
                    {
                        pos=k;
                        mx=pr[k]+k-1;
                    }
            }
        }
        

        String result="";
        for (int t=pos-pr[pos]+1;t<pos+pr[pos];t++)
        {
            if (b[t]!=33) result=result+String.valueOf(b[t]);
        }
        System.out.println(result);
    }
}
