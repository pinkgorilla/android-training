package com.moonlay.android.training.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moonlay.android.training.R;
import com.moonlay.android.training.content.MainMenuContent;
import com.moonlay.android.training.model.MainMenuItem;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnMainMenuItemClickListener}
 * interface.
 */
public class MainMenuFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnMainMenuItemClickListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MainMenuFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MainMenuRecyclerViewAdapter(MainMenuContent.ITEMS, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMainMenuItemClickListener) {
            mListener = (OnMainMenuItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnMainMenuItemClickListener {
        // TODO: Update argument type and name
        void onMainMenuItemClick(MainMenuItem item);
    }

    public class MainMenuRecyclerViewAdapter extends RecyclerView.Adapter<MainMenuFragment.MainMenuViewHolder> {
        private final List<com.moonlay.android.training.model.MainMenuItem> mValues;
        private final OnMainMenuItemClickListener mListener;

        public MainMenuRecyclerViewAdapter(List<MainMenuItem> data, OnMainMenuItemClickListener listener) {
            this.mValues = data;
            this.mListener = listener;
        }

        @Override
        public MainMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_item, parent, false);
            return new MainMenuViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MainMenuViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(holder.mItem.id);
            holder.mNameView.setText(holder.mItem.name);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mListener.onMainMenuItemClick(holder.mItem);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return this.mValues.size();
        }
    }

    public class MainMenuViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mNameView;
        public MainMenuItem mItem;

        public MainMenuViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mNameView = (TextView) view.findViewById(R.id.name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}
