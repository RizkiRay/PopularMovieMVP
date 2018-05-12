
package com.raycoding.popularmoviemvp.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MovieResult implements Parcelable {

    @SerializedName("adult")
    public Boolean Adult;
    @SerializedName("backdrop_path")
    public String BackdropPath;
    @SerializedName("genre_ids")
    public List<Long> GenreIds;
    @SerializedName("id")
    public Long Id;
    @SerializedName("original_language")
    public String OriginalLanguage;
    @SerializedName("original_title")
    public String OriginalTitle;
    @SerializedName("overview")
    public String Overview;
    @SerializedName("popularity")
    public Double Popularity;
    @SerializedName("poster_path")
    public String PosterPath;
    @SerializedName("release_date")
    public String ReleaseDate;
    @SerializedName("title")
    public String Title;
    @SerializedName("video")
    public Boolean Video;
    @SerializedName("vote_average")
    public Double VoteAverage;
    @SerializedName("vote_count")
    public Long VoteCount;

    protected MovieResult(Parcel parcel) {
        GenreIds = new ArrayList<>();
        Adult = parcel.readByte() != 0;
        BackdropPath = parcel.readString();
        parcel.readList(GenreIds, null);
        Id = parcel.readLong();
        OriginalLanguage = parcel.readString();
        OriginalTitle = parcel.readString();
        Overview = parcel.readString();
        Popularity = parcel.readDouble();
        PosterPath = parcel.readString();
        ReleaseDate = parcel.readString();
        Title = parcel.readString();
        Video = parcel.readByte() != 0;
        VoteAverage = parcel.readDouble();
        VoteCount = parcel.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieResult> CREATOR = new Creator<MovieResult>() {
        @Override
        public MovieResult createFromParcel(Parcel parcel) {
            return new MovieResult(parcel);
        }

        @Override
        public MovieResult[] newArray(int i) {
            return new MovieResult[i];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        ArrayList<Long> genreIds = new ArrayList<>();
        parcel.writeByte((byte) (Adult ? 1 : 0));
        parcel.writeString(BackdropPath);
        parcel.writeList(GenreIds);
        parcel.writeLong(Id);
        parcel.writeString(OriginalLanguage);
        parcel.writeString(OriginalTitle);
        parcel.writeString(Overview);
        parcel.writeDouble(Popularity);
        parcel.writeString(PosterPath);
        parcel.writeString(ReleaseDate);
        parcel.writeString(Title);
        parcel.writeByte((byte) (Video ? 1 : 0));
        parcel.writeDouble(VoteAverage);
        parcel.writeLong(VoteCount);

    }
}
