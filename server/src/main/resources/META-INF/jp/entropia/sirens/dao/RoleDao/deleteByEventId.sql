delete role
from role
  inner join song on role.song_id = song.id
where
  event_id = /* eventId */1