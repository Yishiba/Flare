/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package dev.dimension.flare.data.network.misskey.api.model

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param name */
@Serializable

data class IClaimAchievementRequest(

    @SerialName(value = "name") @Required val name: IClaimAchievementRequest.Name

) {

    /**
     * *
     * Values: Notes1,Notes10,Notes100,Notes500,Notes1000,Notes5000,Notes10000,Notes20000,Notes30000,Notes40000,Notes50000,Notes60000,Notes70000,Notes80000,Notes90000,Notes100000,Login3,Login7,Login15,Login30,Login60,Login100,Login200,Login300,Login400,Login500,Login600,Login700,Login800,Login900,Login1000,PassedSinceAccountCreated1,PassedSinceAccountCreated2,PassedSinceAccountCreated3,LoggedInOnBirthday,LoggedInOnNewYearsDay,NoteClipped1,NoteFavorited1,MyNoteFavorited1,ProfileFilled,MarkedAsCat,Following1,Following10,Following50,Following100,Following300,Followers1,Followers10,Followers50,Followers100,Followers300,Followers500,Followers1000,CollectAchievements30,ViewAchievements3min,ILoveMisskey,FoundTreasure,Client30min,Client60min,NoteDeletedWithin1min,PostedAtLateNight,PostedAt0min0sec,SelfQuote,Htl20npm,ViewInstanceChart,OutputHelloWorldOnScratchpad,Open3windows,DriveFolderCircularReference,ReactWithoutRead,ClickedClickHere,JustPlainLucky,SetNameToSyuilo,CookieClicked,BrainDiver
     */
    @Serializable
    enum class Name(val value: kotlin.String) {
        @SerialName(value = "notes1")
        Notes1("notes1"),

        @SerialName(value = "notes10")
        Notes10("notes10"),

        @SerialName(value = "notes100")
        Notes100("notes100"),

        @SerialName(value = "notes500")
        Notes500("notes500"),

        @SerialName(value = "notes1000")
        Notes1000("notes1000"),

        @SerialName(value = "notes5000")
        Notes5000("notes5000"),

        @SerialName(value = "notes10000")
        Notes10000("notes10000"),

        @SerialName(value = "notes20000")
        Notes20000("notes20000"),

        @SerialName(value = "notes30000")
        Notes30000("notes30000"),

        @SerialName(value = "notes40000")
        Notes40000("notes40000"),

        @SerialName(value = "notes50000")
        Notes50000("notes50000"),

        @SerialName(value = "notes60000")
        Notes60000("notes60000"),

        @SerialName(value = "notes70000")
        Notes70000("notes70000"),

        @SerialName(value = "notes80000")
        Notes80000("notes80000"),

        @SerialName(value = "notes90000")
        Notes90000("notes90000"),

        @SerialName(value = "notes100000")
        Notes100000("notes100000"),

        @SerialName(value = "login3")
        Login3("login3"),

        @SerialName(value = "login7")
        Login7("login7"),

        @SerialName(value = "login15")
        Login15("login15"),

        @SerialName(value = "login30")
        Login30("login30"),

        @SerialName(value = "login60")
        Login60("login60"),

        @SerialName(value = "login100")
        Login100("login100"),

        @SerialName(value = "login200")
        Login200("login200"),

        @SerialName(value = "login300")
        Login300("login300"),

        @SerialName(value = "login400")
        Login400("login400"),

        @SerialName(value = "login500")
        Login500("login500"),

        @SerialName(value = "login600")
        Login600("login600"),

        @SerialName(value = "login700")
        Login700("login700"),

        @SerialName(value = "login800")
        Login800("login800"),

        @SerialName(value = "login900")
        Login900("login900"),

        @SerialName(value = "login1000")
        Login1000("login1000"),

        @SerialName(value = "passedSinceAccountCreated1")
        PassedSinceAccountCreated1("passedSinceAccountCreated1"),

        @SerialName(value = "passedSinceAccountCreated2")
        PassedSinceAccountCreated2("passedSinceAccountCreated2"),

        @SerialName(value = "passedSinceAccountCreated3")
        PassedSinceAccountCreated3("passedSinceAccountCreated3"),

        @SerialName(value = "loggedInOnBirthday")
        LoggedInOnBirthday("loggedInOnBirthday"),

        @SerialName(value = "loggedInOnNewYearsDay")
        LoggedInOnNewYearsDay("loggedInOnNewYearsDay"),

        @SerialName(value = "noteClipped1")
        NoteClipped1("noteClipped1"),

        @SerialName(value = "noteFavorited1")
        NoteFavorited1("noteFavorited1"),

        @SerialName(value = "myNoteFavorited1")
        MyNoteFavorited1("myNoteFavorited1"),

        @SerialName(value = "profileFilled")
        ProfileFilled("profileFilled"),

        @SerialName(value = "markedAsCat")
        MarkedAsCat("markedAsCat"),

        @SerialName(value = "following1")
        Following1("following1"),

        @SerialName(value = "following10")
        Following10("following10"),

        @SerialName(value = "following50")
        Following50("following50"),

        @SerialName(value = "following100")
        Following100("following100"),

        @SerialName(value = "following300")
        Following300("following300"),

        @SerialName(value = "followers1")
        Followers1("followers1"),

        @SerialName(value = "followers10")
        Followers10("followers10"),

        @SerialName(value = "followers50")
        Followers50("followers50"),

        @SerialName(value = "followers100")
        Followers100("followers100"),

        @SerialName(value = "followers300")
        Followers300("followers300"),

        @SerialName(value = "followers500")
        Followers500("followers500"),

        @SerialName(value = "followers1000")
        Followers1000("followers1000"),

        @SerialName(value = "collectAchievements30")
        CollectAchievements30("collectAchievements30"),

        @SerialName(value = "viewAchievements3min")
        ViewAchievements3min("viewAchievements3min"),

        @SerialName(value = "iLoveMisskey")
        ILoveMisskey("iLoveMisskey"),

        @SerialName(value = "foundTreasure")
        FoundTreasure("foundTreasure"),

        @SerialName(value = "client30min")
        Client30min("client30min"),

        @SerialName(value = "client60min")
        Client60min("client60min"),

        @SerialName(value = "noteDeletedWithin1min")
        NoteDeletedWithin1min("noteDeletedWithin1min"),

        @SerialName(value = "postedAtLateNight")
        PostedAtLateNight("postedAtLateNight"),

        @SerialName(value = "postedAt0min0sec")
        PostedAt0min0sec("postedAt0min0sec"),

        @SerialName(value = "selfQuote")
        SelfQuote("selfQuote"),

        @SerialName(value = "htl20npm")
        Htl20npm("htl20npm"),

        @SerialName(value = "viewInstanceChart")
        ViewInstanceChart("viewInstanceChart"),

        @SerialName(value = "outputHelloWorldOnScratchpad")
        OutputHelloWorldOnScratchpad("outputHelloWorldOnScratchpad"),

        @SerialName(value = "open3windows")
        Open3windows("open3windows"),

        @SerialName(value = "driveFolderCircularReference")
        DriveFolderCircularReference("driveFolderCircularReference"),

        @SerialName(value = "reactWithoutRead")
        ReactWithoutRead("reactWithoutRead"),

        @SerialName(value = "clickedClickHere")
        ClickedClickHere("clickedClickHere"),

        @SerialName(value = "justPlainLucky")
        JustPlainLucky("justPlainLucky"),

        @SerialName(value = "setNameToSyuilo")
        SetNameToSyuilo("setNameToSyuilo"),

        @SerialName(value = "cookieClicked")
        CookieClicked("cookieClicked"),

        @SerialName(value = "brainDiver")
        BrainDiver("brainDiver");
    }
}
