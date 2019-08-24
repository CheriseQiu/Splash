package com.example.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Constructor;

public class ParallaxLayoutInflater extends LayoutInflater {

    private ParallaxFragment fragment;

    protected ParallaxLayoutInflater(LayoutInflater original, Context newContext, ParallaxFragment fragment) {
        super(original, newContext);
        this.fragment = fragment;

        setFactory2(new ParallaxFactory(this));

    }

    protected ParallaxLayoutInflater(LayoutInflater original, Context newContext) {
        super(original, newContext);
    }

    @Override
    public LayoutInflater cloneInContext(Context context) {
        return new ParallaxLayoutInflater(this, context, fragment);
    }

    class ParallaxFactory implements Factory2 {

        private final String[] sClassPrefix = new String[]{
                "android.widget."
        };
        private LayoutInflater layoutInflater;

        public ParallaxFactory(LayoutInflater layoutInflater) {
            this.layoutInflater = layoutInflater;
        }

        @Nullable
        @Override
        public View onCreateView(@Nullable View view, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attributeSet) {
            /**
             * view 根 顶层view
             * name ---控件名称
             * context--上下文
             * AttributeSet--属性
             */

            View view1 = null;
            view = createMyView(name, context, attributeSet);

            return null;
        }

        private View createMyView(String name, Context context, AttributeSet attributeSet) {

            if (name.contains(".")) {
               return reflectView(name, null, context, attributeSet);
            } else {
                for (String prefix : sClassPrefix) {
                    View view = reflectView(name, prefix, context, attributeSet);
                    //获取系统控件的属性
                    if (view != null) {
                        return view;
                    }
                }
//                reflectView(name,null,context,attributeSet);
            }
            return null;
        }

        private View reflectView(String name, String prefix, Context context, AttributeSet attributeSet) {
            try {
                Class cla = Class.forName(name);
                Constructor<View> constructor = Constructor.class.newInstance();
                return layoutInflater.createView(name, prefix, attributeSet);
            } catch (Exception e) {
                return null;
            }
        }


        @Nullable
        @Override
        public View onCreateView(@NonNull String s, @NonNull Context context, @NonNull AttributeSet attributeSet) {
            return null;
        }
    }
}
