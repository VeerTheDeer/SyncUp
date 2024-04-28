# SyncUp
**UWB Hacks AI Hackathon Project**

**Project Name: SyncUp**

**Overview:**

SyncUp is a project developed during the UWB Hacks AI Hackathon held from April 26-28, 2024. Our team participated in the entertainment track, aiming to tackle the issue of inaccurate online transcripts. We noticed that many online transcripts fail to accurately match the audio, leading to discrepancies between what is spoken/sung and what is transcribed.

To address this issue, we focused on developing a solution using OpenAI Whisper API for audio-to-text conversion. Our goal was to create a tool to accurately transcribe music lyrics by listening to the audio. We used the song "Just the Two of Us" by Grover Washington as a proof of concept.

**Technologies Used:**

OpenAI Whisper API: Used for converting audio to text.
Genius API: Utilized to retrieve the full lyrics of the selected song.

SyncUp Algorithm: Our team developed it to synchronize the transcribed text and audio.

**How it Works:**

Speech-to-Text Conversion: This feature is built using OpenAI's Whisper API, Silero VAD API, and Faster-Whisper API to listen to music and convert it into text.

Lyrics Retrieval: Using the LyricsGenius API, we fetch the song's full lyrics from the Genius Database being analyzed.

SyncUp Algorithm: Our proprietary algorithm, SyncUp, is employed to synchronize the transcribed text with the audio. This ensures accurate alignment between the audio playback and the displayed lyrics/transcript.

Example Usage:
Users can upload or input the song's audio file they want to transcribe. SyncUp will then process the audio, retrieve the lyrics, and display the synchronized transcript for the user to view.

**Future Improvements:**

Integration of additional music sources and platforms for a wider range of songs.
Enhancement of synchronization algorithm for improved accuracy.
User-friendly interface development for seamless interaction.
