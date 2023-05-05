package com.example.taja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taja.databinding.ArticleItemBinding;
import com.example.taja.databinding.EventItemBinding;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {
    List<Article> localDataSet;

    EventItemBinding eventItemBinding;

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView title, username, date;

        public EventViewHolder(EventItemBinding eventItemBinding) {
            super(eventItemBinding.getRoot());

            title = eventItemBinding.title;
            username = eventItemBinding.username;
            date = eventItemBinding.date;
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getUsername() {
            return username;
        }

        public TextView getDate() {
            return date;
        }
    }

    public EventListAdapter(List<Article> localDataSet, Context context) {
        this.localDataSet = localDataSet;
    }

    @NonNull
    @Override
    public EventListAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventItemBinding eventItemBinding1 = EventItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new EventListAdapter.EventViewHolder(eventItemBinding1);
    }

    @Override
    public void onBindViewHolder(@NonNull EventListAdapter.EventViewHolder holder, int position) {
        holder.getTitle().setText(localDataSet.get(position).getTitle());
        holder.getUsername().setText(localDataSet.get(position).getUsername());
        holder.getDate().setText(localDataSet.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
