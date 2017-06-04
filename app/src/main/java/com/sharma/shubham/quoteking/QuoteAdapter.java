package com.sharma.shubham.quoteking;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by hp on 9/29/2016.
 */

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.ViewHolder> {
    private List<Quote> quotesList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView quoteView,authorView;

        public ViewHolder(View view) {
            super(view);
            quoteView = (TextView) view.findViewById(R.id.quote_text_view);
            authorView = (TextView) view.findViewById(R.id.author_text_view);
        }



    }

    public QuoteAdapter(List<Quote> quotes) {
        this.quotesList = quotes;
    }

    @Override
    public QuoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuoteAdapter.ViewHolder holder, int position) {
        final Quote quote = quotesList.get(position);
        holder.quoteView.setText(quote.getQuote());
        holder.authorView.setText("- " + quote.getAuthor());
    }

    @Override
    public int getItemCount() {
        return quotesList.size();
    }

    public Quote getItem(int position) {
        return quotesList.get(position);
    }

}