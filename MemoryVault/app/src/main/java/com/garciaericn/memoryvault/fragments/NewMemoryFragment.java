package com.garciaericn.memoryvault.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garciaericn.memoryvault.R;
import com.garciaericn.memoryvault.data.Memory;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 9/16/14.
 */
public class NewMemoryFragment extends Fragment {

    public static final String TAG = "NewMemoryFragment.TAG";

    private Memory memory;
    private NewMemoryFragmentCallbacks activity;

    public interface NewMemoryFragmentCallbacks {
        public void addMemory(Memory newMemory);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate entered");

        setHasOptionsMenu(true);

        Bundle b = getArguments();
        if (b != null && b.containsKey(Memory.EVENT_KEY)) {
            memory = new Memory(b);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView entered");

        // Load layout
        return inflater.inflate(R.layout.fragment_new_memory, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (NewMemoryFragmentCallbacks) activity;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save_memory : {
                Log.i(TAG, "Save from fragments");
                save();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void save() {
        Log.i(TAG, "save entered");

        View view = getView();
        Memory newMemory;
        int numGuests;

        if (view != null) {
            // Obtain all fields
            TextView eventTitleTV = (TextView) view.findViewById(R.id.newEventNameTV);
            String eventTitle = String.valueOf(eventTitleTV.getText());
            if (eventTitle == null || eventTitle.isEmpty()) {
                alertDialog("Please enter and event title");
                return;
            }

            TextView numGuestsTV = (TextView) view.findViewById(R.id.newGuestsTV);
            String stringGuests = String.valueOf(numGuestsTV.getText());
            if (stringGuests == null || stringGuests.isEmpty()) {
                alertDialog("Please enter how many people were included");
                return;
            } else {
            numGuests = Integer.parseInt(stringGuests);
            }

            TextView eventLocationTV = (TextView) view.findViewById(R.id.newLocationTV);
            String eventLocation = String.valueOf(eventLocationTV.getText());
            if (eventLocation == null || eventLocation.isEmpty()) {
                alertDialog("Please enter a location");
                return;
            }

            TextView eventNotesTV = (TextView) view.findViewById(R.id.newNotesTV);
            String eventNotes = String.valueOf(eventNotesTV.getText());


            if (eventTitle != null && stringGuests != null && eventLocation != null) {
                newMemory = new Memory(eventTitle, numGuests, eventLocation, eventNotes);

                activity.addMemory(newMemory);
            }
        } else {
            alertDialog("Please bare with me as I work to fix the issue");
        }
    }

    public void alertDialog (String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Something isn't right...")
                .setMessage(message)
                .create()
                .show();
    }
}
