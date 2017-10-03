DROP TABLE IF EXISTS task_list;

CREATE TABLE task_list (
  id INT AUTO_INCREMENT PRIMARY KEY,
  description       VARCHAR(100) NOT NULL,
  execution_status  VARCHAR(20)  DEFAULT 'В процессе' NOT NULL,
  importance_status VARCHAR(20)  DEFAULT 'Есть время' NOT NULL,
  last_update_date  TIMESTAMP DEFAULT now() NOT NULL
);