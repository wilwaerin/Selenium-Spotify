# Selenium-Spotify

Hello,

We created this "READ ME" file to talk about a problem with Spotify.
The problem is on spotify if there is no playlist on the search page
When the playlist is created from the song "Yolla", the playlist is
It doesn't include the song in it and changes the name of the playlist to "1st Playlist".
forming. At least one for not adding songs to the playlist for this reason
we are able to run the script if there is an existing playlist. Therefore, manually
We created playlists. Without deleting these playlists when you check
We will be glad if you run the test. We wish you good work.

Regards,

Team Crazy Pirates		

<br>
<h3>Automation Steps</h3>

•	Go to https://open.spotify.com/

•	Click the Sign In button

•	Successful Login

•	It is checked with the user name it is logged in.

•	Click on Search tab from the left menu

•	Check that the Search page is opened

•	Search for "Yolla" in the search field on the Search page

•	Hover the first song under the Songs section on the Search page (hover element)

•	On the Search page, in the Songs section, the other options button of the first song (...) is clicked.

•	In the dropdown of the first song, the Add playlist field is hovered (hover element)

•	In the new dropdown that opens, click Create playlist.

•	Click on the newly created playlist from the left menu

•	Hover song "Yolla" in playlist (hover element)

•	Click the play song button

•	10 seconds wait

•	Hover song "Yolla" in playlist (hover element)

•	The song is stopped

•	Hover song "Yolla" in playlist (hover element)

•	Click the other options button of the "Yolla" song (...)

•	In the dropdown that opens, the Remove from this playlist button is clicked.

•	Check that the song has been deleted

•	Click the other options button (...) just below the photo section of the playlist.

•	Click the Delete button in the dropdown that opens.

•	Delete operation is confirmed in the opened modal

•	Expect Result: Check that the playlist is deleted



