package com.example.selenium4java17.Sawal;

import java.util.HashSet;

public class Suduko {
    public static void main(String[] args) {
//        String[][] board = new String[][]{{"1", "2", ".", ".", "3", ".", ".", ".", "."}, {
//        "4", ".", ".", "5", ".", ".", ".", ".", "."},{".", "9", "8", ".", ".", ".", ".", ".", "3"},{
//        "5", ".", ".", ".", "6", ".", ".", ".", "4"},{".", ".", ".", "8", ".", "3", ".", ".", "5"},{
//        "7", ".", ".", ".", "2", ".", ".", ".", "6"},{".", ".", ".", ".", ".", ".", "2", ".", "."},{
//        ".", ".", ".", "4", "1", "9", ".", ".", "8"},{".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        String[][] board = new String[][]{{".", ".", "4", ".", ".", ".", "6", "3", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},{"5", ".", ".", ".", ".", ".", ".", "9", "."},{
        ".", ".", ".", "5", "6", ".", ".", ".", "."},{"4", ".", "3", ".", ".", ".", ".", ".", "1"},{
        ".", ".", ".", "7", ".", ".", ".", ".", "."},{".", ".", ".", "5", ".", ".", ".", ".", "."},{
        ".", ".", ".", ".", ".", ".", ".", ".", "."},{".", ".", ".", ".", ".", ".", ".", ".", "."}};
        System.out.println(checkSudoku(board));
    }
        public static boolean checkSudoku (String[][]board){
            for (int i = 0; i < 9; i++) {
                HashSet<String> dupRow = new HashSet<>();
                HashSet<String> dupCol = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == ".") continue;
                    if (dupRow.contains(board[i][j])) {
                        return false;
                    } else dupRow.add(board[i][j]);

                    if (board[j][i] == ".") continue;
                    if (dupCol.contains(board[j][i])) {
                        return false;
                    } else dupCol.add(board[j][i]);
                }
            }
            for (int i = 0; i < board.length; i++) {
                HashSet<String> dup = new HashSet<>();
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        int row = (i / 3) * 3 + j;
                        int col = (i / 3) * 3 + k;
                        if (board[row][col] == ".") continue;
                        if (dup.contains(board[row][col])) {
                            return false;
                        } else dup.add(board[row][col]);
                    }
                }
            }
            return true;
        }
    }
