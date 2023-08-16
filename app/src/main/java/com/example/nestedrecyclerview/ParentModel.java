package com.example.nestedrecyclerview;

import java.util.List;

public class ParentModel {
    String Title;
    List<ChildModel> childModels;

    public ParentModel(String title, List<ChildModel> childModels) {
        Title = title;
        this.childModels = childModels;
    }
}
