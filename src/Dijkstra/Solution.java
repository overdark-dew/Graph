package Dijkstra;

//������� ������:
//7 11 1
//1 2 1
//1 3 7
//2 4 4
//2 5 2
//3 2 4
//3 5 5
//4 5 3
//5 3 3
//5 4 10
//6 7 3
//7 6 4

//��������� ���������:
//0 1 6 5 3 -1 -1
//1: 1
//2: 1 2
//3: 1 2 5 3
//4: 1 2 4
//5: 1 2 5
//6:
//7:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    
    private static int INF = Integer.MAX_VALUE / 2;
    
    private int n; //���������� ������ � �������
    private int m; //����������� ��� � �������
    private ArrayList<Integer> adj[]; //������ ���������
    private ArrayList<Integer> weight[]; //��� ����� � �������
    private boolean used[]; //������ ��� �������� ���������� � ���������� � �� ���������� ��������
    private int dist[]; //������ ��� �������� ���������� �� ��������� �������
    //������ �������, ����������� ��� �������������� ����������� ���� �� ��������� �������
    private int pred[]; 
    int start; //��������� �������, �� ������� ������ ���������� �� ���� ������
    
    private BufferedReader cin;
    private PrintWriter cout; 
    private StringTokenizer tokenizer;
    
    //��������� ������� ��������� �������� �� ��������� �������
    private void dejkstra(int s) { 
        dist[s] = 0; //���������� ���������� �� ��������� ������� ����� 0
        for (int iter = 0; iter < n; ++iter) {
            int v = -1;
            int distV = INF;
            //�������� �������, ���������� ���������� �� �������� ��� �� �������
            for (int i = 0; i < n; ++i) {
                if (used[i]) {
                    continue;
                }
                if (distV < dist[i]) {
                    continue;
                }
                v = i;
                distV = dist[i];
            }
            //������������� ��� ����, ��������� �� ��������� �������
            for (int i = 0; i < adj[v].size(); ++i) {
                int u = adj[v].get(i);
                int weightU = weight[v].get(i);
                //���������� �������
                if (dist[v] + weightU < dist[u]) {
                    dist[u] = dist[v] + weightU;
                    pred[u] = v;
                }
            }
            //�������� ������� v �������������, �� ��� ������� ���������� ����������
            used[v] = true;
        }
    }
    
    //��������� ���������� ������� ������ � �������
    private void readData() throws IOException {
        cin = new BufferedReader(new InputStreamReader(System.in));
        cout = new PrintWriter(System.out);
        tokenizer = new StringTokenizer(cin.readLine());
        
        n = Integer.parseInt(tokenizer.nextToken()); //��������� ���������� ������ �����
        m = Integer.parseInt(tokenizer.nextToken()); //��������� ���������� ����� �����
        start = Integer.parseInt(tokenizer.nextToken()) - 1;
        
        //�������������� ������ ��������� ����� ����������� n
        adj = new ArrayList[n]; 
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<Integer>();
        }
        //������������� ������, � ������� �������� ���� �����
        weight = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            weight[i] = new ArrayList<Integer>();
        }
        
        //��������� ����, �������� ������� �����
        for (int i = 0; i < m; ++i) {
            tokenizer = new StringTokenizer(cin.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            u--;
            v--;
            adj[u].add(v);
            weight[u].add(w);
        }
        
        used = new boolean[n];
        Arrays.fill(used, false);
        
        pred = new int[n];
        Arrays.fill(pred, -1);
        
        dist = new int[n];
        Arrays.fill(dist, INF);
        
    }

    //��������� �������������� ����������� ���� �� ������� �������
    void printWay(int v) {
        if (v == -1) {
            return;
        }
        printWay(pred[v]);
        cout.print((v + 1) + " ");
    }
    
    //��������� ������ ������ � �������
    private void printData() throws IOException {
        for (int v = 0; v < n; ++v) {
            if (dist[v] != INF) {
                cout.print(dist[v] + " ");
            } else {
                cout.print("-1 ");
            }
        }
        cout.println();
        for (int v = 0; v < n; ++v) {
            cout.print((v + 1) + ": ");
            if (dist[v] != INF) {
                printWay(v);
            } 
            cout.println();
        }
                
        cin.close();
        cout.close();
    }
    
    private void run() throws IOException {
        readData();
        dejkstra(start);
        printData();
        
        cin.close();
        cout.close();
    }
    
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.run();
    }
}