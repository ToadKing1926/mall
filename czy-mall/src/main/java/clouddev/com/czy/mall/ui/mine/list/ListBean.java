package clouddev.com.czy.mall.ui.mine.list;

import android.widget.CompoundButton;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import clouddev.com.czy.fragment.CoreFragment;

/**
 * Created by 29737
 */

public class ListBean implements MultiItemEntity
{
    private int mItemType = 0;
    private String mImageUrl = null;
    private String mText = null;
    private String mValue = null;
    private int mId = 0;
    private CoreFragment mFragment = null;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = null;

    public ListBean(int itemType, String imageUrl, String text, String value, int id, CoreFragment fragment, CompoundButton.OnCheckedChangeListener listener) {
        this.mItemType = itemType;
        this.mImageUrl = imageUrl;
        this.mText = text;
        this.mValue = value;
        this.mId = id;
        this.mFragment = fragment;
        this.mOnCheckedChangeListener = listener;
    }

    public String getImageUrl()
    {
        return mImageUrl;
    }

    public String getText()
    {
        if(mText == null)
        {
            return "";
        }
        return mText;
    }

    public String getValue()
    {
        if(mValue == null)
        {
            return "";
        }
        return mValue;
    }

    public int getId() {
        return mId;
    }

    public CoreFragment getFragment() {
        return mFragment;
    }

    public CompoundButton.OnCheckedChangeListener getListener() {
        return mOnCheckedChangeListener;
    }

    @Override
    public int getItemType()
    {
        return mItemType;
    }

    public static final class Builder
    {
        private int id = 0;
        private int itemType = 0;
        private String imageUrl = null;
        private String text = null;
        private String value = null;
        private CoreFragment fragment = null;
        private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = null;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setItemType(int itemType) {
            this.itemType = itemType;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setValue(String value)
        {
            this.value = value;
            return this;
        }

        public Builder setFragment(CoreFragment fragment)
        {
            this.fragment = fragment;
            return this;
        }

        public Builder setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener)
        {
            this.onCheckedChangeListener = onCheckedChangeListener;
            return this;
        }

        public ListBean build()
        {
            return new ListBean(itemType,imageUrl,text,value,id,fragment,onCheckedChangeListener);
        }
    }
}
