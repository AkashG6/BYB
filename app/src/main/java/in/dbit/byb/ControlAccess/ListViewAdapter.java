package in.dbit.byb.ControlAccess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import in.dbit.byb.R;

/**
 * Created by Belal on 9/5/2017.
 */

public class ListViewAdapter extends ArrayAdapter<studlist> {

    //the hero list that will be displayed
    private List<studlist> studList;

    //the context object
    private Context mCtx;

    //here we are getting the herolist and context
    //so while creating the object of this adapter class we need to give herolist and context
    public ListViewAdapter(List<studlist> studList, Context mCtx) {
        super(mCtx, R.layout.activity_listitems, studList);



        this.studList = studList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.activity_listitems, null, true);

        //getting text views
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        //TextView textViewImageUrl = listViewItem.findViewById(R.id.textViewImageUrl);

        //Getting the hero for the specified position
        studlist stud = studList.get(position);

        //setting hero values to textviews
        textViewName.setText(stud.getName());
        //textViewImageUrl.setText(hero.getImageUrl());

        //returning the listitem
        return listViewItem;
    }
}
