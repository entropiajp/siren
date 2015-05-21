select userId from role
  inner join member on role.member_id = member.id
  where role.id = /* roleId */22 and member.userId = /* userId */'9558edca-cf51-4ee5-8035-c09973c699ec'