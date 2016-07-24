# ZoomHeaderViewPager

![ZoomHeaderViewPager Demo][demo_gif]

# Usage

Add the ZoomHeaderViewPager widget to your layout. 
ZoomHeaderViewPager should be add as ViewPager's parent. ZoomHeaderViewPager can not have other view than ViewPager.

```xml
    <com.patryk1007.zoomviewpager.ZoomHeaderViewPager
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:hvPadding="10dp"
        app:hvTextAlpha="0.2"
        app:hvTextAlphaActiveTab="0.9"
        app:hvTextColor="@android:color/holo_green_dark"
        app:hvTextColorActiveTab="@android:color/holo_red_dark"
        app:hvTextScale="0.6"
        app:hvTextScaleActiveTab="0.9"
        app:hvTextSize="20sp">

        <android.support.v4.view.ViewPager
            android:id="@+id/view_pager"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

        </android.support.v4.view.ViewPager>

    </com.patryk1007.zoomviewpager.ZoomHeaderViewPager>

```

ViewPager's adapter have to override getPageTitle method.

```java


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Title1";
                case 1:
                    return "Title2";
                case 2:
                    return "Title3";
                default:
                    return "Title default";

            }
        }

```

#Download


    compile 'com.patryk1007:zoomviewpager:1.0'

# Attributes


| attr | description |
|:---|:---|
| hvTextSize | Set header's text size, default 14sp |
| hvTextColor | Set header's text color, default black |
| hvTextColorActiveTab | Set active header's text color, default black |
| hvTextAlpha | Set header's text alpha, default 1.0 (full visible) |
| hvTextAlphaActiveTab | Set active header's text alpha, default 1.0 (full visible) |
| hvTextScale | Set header's text scale, default 1.0 (without scale)  |
| hvTextScaleActiveTab |  Set active header's text scale, default 1.0 (without scale)  |
| hvPadding | Set header's padding, default 0 |

# LICENSE

```
Copyright (C) 2016 patryk1007

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[demo_gif]: https://bytebucket.org/moodup/headerviewpager/raw/731ab624167cf459dc8634719de728e0396bcf14/screen/demo1.gif?token=ad81426659b7884ea43e60a7f5d3db0eab359346
