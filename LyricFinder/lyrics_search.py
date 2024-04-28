import lyricsgenius as lg

genius_access_token = 'f4u-ieDiEDkkgrVtsXTd0Bo5n0XJJ8Do7dpt2ZWl-oCLFxf2l6LqnJZWqrA-cXPi'

#Genius obj
genius = lg.Genius(genius_access_token, remove_section_headers=True)

#Inputing lyrics to search
song_dict = genius.search_lyrics("We look for love no time for tears",per_page=1)
song_dict_section = song_dict.get('sections')

#Scraping genius
section = song_dict_section[0]
hits = section.get('hits')
hits_dict = hits[0]
result = hits_dict.get('result')
get_title = result.get('title')
get_artist = result.get('artist_names')

#Scraping lyrics
song = genius.search_song(title=get_title,artist=get_artist)
lyrics = song.lyrics
lyrics_start = get_title + " Lyrics"
lyrics.find(lyrics_start)
formatted_lyrics = lyrics[lyrics.find(lyrics_start):len(lyrics)]

#Printing lyrics
with open("lyrics.txt", mode="wt") as f:
    f.write(formatted_lyrics)
f.close()
