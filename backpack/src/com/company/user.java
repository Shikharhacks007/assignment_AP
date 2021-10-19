package com.company;

import java.util.ArrayList;

public interface user {
    void menu();
    void view_comments(ArrayList<comment> temp);
    void add_comments(ArrayList<comment> temp, comment obj);
}
