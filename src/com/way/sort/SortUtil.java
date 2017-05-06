package com.way.sort;

public class SortUtil {
    
    public static void bubbleSort(int[] a){
        int temp;
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    
    public static void selectSort(int[] a){
        int index;
        int temp;
        
        for(int i=0;i<a.length-1;i++){
            index=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[index]){
                    index=j;
                }
            }
            if(index!=i){
                temp=a[i];
                a[i]=a[index];
                a[index]=temp;
            }
        }
    }
    
    public static void insertionSort(int[] a){
        int i,j,temp;
        for(i=1;i<a.length;i++){
            temp=a[i];
            j=i-1;
            while(j>=0&&temp<a[j]){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
        }
    }
    
    public static void shellSort(int[] a){
        int i,j;
        int r,temp;
        for(r=a.length/2;r>=1;r/=2){
            for(i=r;i<a.length;i++){
                temp=a[i];
                j=i-r;
                while(j>=0&&temp<a[j]){
                    a[j+r]=a[j];
                    j-=r;
                }
                a[j+r]=temp;
            }
        }
    }
    
    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    
    public static void quickSort(int[] arr,int left,int right){
        int f,t;
        int rtemp,ltemp;
        
        ltemp=left;
        rtemp=right;
        f=arr[(left+right)/2];
        
        while(ltemp<rtemp){
            while(arr[ltemp]<f){
                ++ltemp;
            }
            while(arr[rtemp]>f){
                --rtemp;
            }
            
                t=arr[ltemp];
                arr[ltemp]=arr[rtemp];
                arr[rtemp]=t;
                --rtemp;
                ++ltemp;
            
        }
        
        if(ltemp==rtemp){
            ltemp++;
        }
        
        if(left<rtemp){
            quickSort(arr, left, ltemp-1);
        }
        
        if(ltemp<right){
            quickSort(arr, rtemp+1, right);
        }
    }
    
    public static void quickSort2(int[] a,int left,int right){
        int tleft=left;
        int tright=right;
        int flag=a[tleft];
        while(tleft<tright){
            while(a[tright]>flag){
                tright--;
            }
            a[tleft]=a[tright];
            while(a[tleft]<flag){
                tleft++;
            }
            a[tright]=a[tleft];
        }
        a[tleft]=flag;
        
        if(tleft>left)
            quickSort2(a,left,tleft-1);
        if(tleft<right)
            quickSort2(a,tleft+1,right);
    }   
    public static void heapSort(int[] a){
        heapSort(a,a.length);
    }
    
    public static void heapSort(int[] a,int n){
        int i,j,k;
        for(i=n/2-1;i>=0;i--){
            while(2*i+1<n){
                j=2*i+1;
                if((j+1)<n){
                    if(a[j]<a[j+1])
                        j++;
                }
                if(a[i]<a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                    i=j;
                }
                else{
                    break;
                }
            }
        }        
        
        System.out.println("The big root heap:");
        for(int h=0;h<n;h++){
            System.out.println(a[h]);
        }
        System.out.println("-------------------");
        
        for(i=n-1;i>0;i--){
            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            k=0;
            while(2*k+1<i){
                j=2*k+1;
                if((j+1)<i){
                    if(a[j]<a[j+1])
                        j++;
                }
                if(a[k]<a[j]){
                    temp=a[k];
                    a[k]=a[j];
                    a[j]=temp;
                    k=j;
                }
                else{
                    break;
                }
                    
            }
        }
    }
    
    static void mergeOne(int[] a,int[] b,int n,int len){
        int i,j,k,s,e;
        s=0;
        while(s+len<n){
            e=s+2*len-1;
            e=e>=n?n-1:e;
            k=s;
            i=s;
            j=s+len;
            while(i<s+len&&j<=e){
                if(a[i]<=a[j]){
					b[k++]=a[i++];
				}
				else{
					b[k++]=a[j++];
				}
            }
            while(i<s+len){
                b[k++]=a[i++];
            }
            while(j<=e){
                b[k++]=a[j++];
            }
            s=e+1;
			
        }
        if(s<n){
            for(;s<n;s++){
                b[s]=a[s];
            }
        }
    }
    
    public static void mergeSort(int a[],int n){
        int h,len,f;
        len=1;
        f=0;
        int[] p=new int[n];
        while(len<n){
            if(f==1){
                mergeOne(p, a, n, len);
            }else{
                mergeOne(a, p, n, len);
            }
            len=len*2;
            f=1-f;
            if(f==1){
                for(h=0;h<n;h++){
                    a[h]=p[h];
                }
            }
        }
            
    }
    
    public static void mergeSort(int[] a){
        mergeSort(a, a.length);
    }
    public static void printArr(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    
    
}
