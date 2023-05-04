package com.example.taja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taja.databinding.ArticleItemBinding;

import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {
    List<Article> localDataSet;

    ArticleItemBinding articleItemBinding;

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView title, username, date;

        public ArticleViewHolder(ArticleItemBinding articleItemBinding) {
            super(articleItemBinding.getRoot());

            title = articleItemBinding.title;
            username = articleItemBinding.username;
            date = articleItemBinding.date;
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

    public ArticleListAdapter(List<Article> localDataSet, Context context) {
        this.localDataSet = localDataSet;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArticleItemBinding articleItemBinding1 = ArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ArticleViewHolder(articleItemBinding1);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.getTitle().setText(localDataSet.get(position).getTitle());
        holder.getUsername().setText(localDataSet.get(position).getUsername());
        holder.getDate().setText(localDataSet.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}