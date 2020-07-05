package com.example.xyzreader.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;
import com.example.xyzreader.data.ArticleBody;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ReaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<ArticleBody> articleBodyArrayList = new ArrayList<>();

    public ReaderAdapter(Activity activity, ArrayList<ArticleBody> storeArticleBodyArrayList) {
        this.mContext = activity;
        this.articleBodyArrayList = storeArticleBodyArrayList;

    }

    public class TextLineViewHolder extends RecyclerView.ViewHolder {

        TextView mTextLine;

        public TextLineViewHolder(View itemView) {
            super(itemView);

            mTextLine =itemView.findViewById(R.id.text_line);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_body_list_item,
                parent, false);
        return new TextLineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ArticleBody item = getValueAt(position);
        ReaderAdapter.TextLineViewHolder textLineViewHolder = (ReaderAdapter.TextLineViewHolder)holder;
        if (item != null) {
            setupValuesInPosition(textLineViewHolder, item);
        }
    }

    private ArticleBody getValueAt(int position) {
        return articleBodyArrayList.get(position);
    }

    private void setupValuesInPosition(ReaderAdapter.TextLineViewHolder itemHolder, ArticleBody
            articleBody) {
        if (articleBody != null) {
            itemHolder.mTextLine.setTypeface(Typeface.createFromAsset(mContext.getResources().getAssets(), "Rosario-Regular.ttf"));
            itemHolder.mTextLine.setText(Html.fromHtml(articleBody.getTextLine()));
        }
    }

    @Override
    public int getItemCount() {
        return articleBodyArrayList.size();
    }
}
