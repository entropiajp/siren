select
  role.id as id,
  song.id as song_id,
  UserConnection.userId as userId,
  role.name as name,
  role.required as required,
  UserProfile.name as member_name,
  UserConnection.imageUrl as imageUrl
from role
  inner join song on role.song_id = song.id
  left outer join member on role.member_id = member.id
  left outer join UserProfile on member.userId = UserProfile.userId
  left outer join UserConnection on member.userId = UserConnection.userId
where song.event_id = /* eventId */6