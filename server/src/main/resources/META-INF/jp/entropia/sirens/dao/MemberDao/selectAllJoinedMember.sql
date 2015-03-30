select
  member.id,
  UserProfile.name,
  UserConnection.displayName,
  UserConnection.profileUrl,
  UserConnection.imageUrl,
  member.attend_party,
  case
    when manager.member_id is NULL then false
    else true
  end as admin
from member
  inner join UserProfile on member.userId = UserProfile.userId
  inner join UserConnection on member.userId = UserConnection.userId
  left outer join manager on member.id = manager.member_id
where
  member.event_id = /* eventId */1
order by member.id    