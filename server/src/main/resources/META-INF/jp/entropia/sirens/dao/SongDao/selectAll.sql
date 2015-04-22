select
  song.id,
  song.event_id,
  song.tune_id,
  song.playable,
  song.song_order,
  tune.name,
  tune.time,
  tune.artist,
  tune.source
from song
  inner join tune on song.tune_id = tune.id
where
  song.event_id = /* eventId */3
order by
  playable DESC,
  song.song_order