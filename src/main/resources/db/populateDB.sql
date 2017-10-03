DELETE FROM task_list;

INSERT INTO task_list (description, execution_status, importance_status, last_update_date) VALUES
  ('Изучить алгоритмы', DEFAULT, DEFAULT, now()),
  ('Приготовить суп', 'Готово', DEFAULT, '2015-09-20 17:30:00'),
  ('Забрать документы', DEFAULT, 'Срочно', now());