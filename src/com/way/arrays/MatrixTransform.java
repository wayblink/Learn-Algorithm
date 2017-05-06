package com.way.arrays;

public class MatrixTransform {

    //rotate clockwise
    public static int[][] rotateACW(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        
        int[][] newmat=new int[n][m];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                newmat[n-1-j][i]=matrix[i][j];
            }
        }
        return newmat;
        
    }
    
    //rotate anticlockwise
    public static int[][] rotateCW(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        
        int[][] newmat=new int[n][m];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                newmat[j][m-1-i]=matrix[i][j];
            }
        }
        return newmat;
        
    }
    
    //flip vertical
    public static int[][] flipV(int[][] mat){
        int m=mat.length;
        int n=mat[0].length;
        
        int[][] newmat=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                newmat[m-1-i][j]=mat[i][j];
            }
        }
        return newmat;
    }
    
    //flip horizontal
    public static int[][] flipH(int[][] mat){
        int m=mat.length;
        int n=mat[0].length;
        
        int[][] newmat=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                newmat[i][n-1-j]=mat[i][j];
            }
        }
        return newmat;
    }
    
    
    public static void main(String[] args) {

        int[][] matrix={{1,2,3},{4,5,6}};

        System.out.println("逆时针旋转");
        int[][] newmat1=rotateACW(matrix);
        
        for(int i=0;i<newmat1.length;i++){
            for(int j=0;j<newmat1[0].length;j++){
                System.out.print(newmat1[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println("顺时针旋转");
        int[][] newmat2=rotateCW(matrix);
        
        for(int i=0;i<newmat2.length;i++){
            for(int j=0;j<newmat2[0].length;j++){
                System.out.print(newmat2[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println("水平翻转");
        int[][] newmat3=flipH(matrix);
        
        for(int i=0;i<newmat3.length;i++){
            for(int j=0;j<newmat3[0].length;j++){
                System.out.print(newmat3[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println("垂直翻转");
        int[][] newmat4=flipV(matrix);
        
        for(int i=0;i<newmat4.length;i++){
            for(int j=0;j<newmat4[0].length;j++){
                System.out.print(newmat4[i][j]+" ");
            }
            System.out.println();
        }
    }

}
