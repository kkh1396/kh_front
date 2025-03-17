-- * �Ʒ� ������ �����Ͽ� ������ �� �Ʒ� �������� �������ּ���.
--   USERNAME / PWD : C##TEST250317 / TEST0317

create user C##TESET250317 identified by TEST0317;
grant connect, resource to C##TESET250317;

alter user C##TESET250317 default tablespace users quota unlimited on users;
--------------------------------------------------------------------------------------------------------
DROP TABLE DEPARTMENTS;
DROP TABLE EMPLOYEES;

-- D0EPARTMENTS ���̺� ����
CREATE TABLE DEPARTMENTS (
    DEPT_ID NUMBER PRIMARY KEY,
    DEPT_NAME VARCHAR2(50) NOT NULL
);

-- EMPLOYEES ���̺� ����
CREATE TABLE EMPLOYEES (
    EMP_ID NUMBER PRIMARY KEY,
    EMP_NAME VARCHAR2(50) NOT NULL,
    SALARY NUMBER,
    HIRE_DATE DATE,
    DEPT_ID NUMBER,
    FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENTS(DEPT_ID)
);

-- DEPARTMENTS ������ ����
INSERT INTO DEPARTMENTS (DEPT_ID, DEPT_NAME) VALUES (1, '�λ��');
INSERT INTO DEPARTMENTS (DEPT_ID, DEPT_NAME) VALUES (2, '�繫��');
INSERT INTO DEPARTMENTS (DEPT_ID, DEPT_NAME) VALUES (3, 'IT�μ�');

-- EMPLOYEES ������ ����
INSERT INTO EMPLOYEES (EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_ID) VALUES (101, 'ȫ�浿', 3500000, TO_DATE('2020-01-15', 'YYYY-MM-DD'), 1);
INSERT INTO EMPLOYEES (EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_ID) VALUES (102, '��ö��', 3200000, TO_DATE('2019-03-22', 'YYYY-MM-DD'), 2);
INSERT INTO EMPLOYEES (EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_ID) VALUES (103, '�̿���', 3800000, TO_DATE('2021-07-10', 'YYYY-MM-DD'), 3);
INSERT INTO EMPLOYEES (EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_ID) VALUES (104, '������', 4500000, TO_DATE('2018-11-05', 'YYYY-MM-DD'), 2);
INSERT INTO EMPLOYEES (EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_ID) VALUES (105, '�ֹ�ȣ', 4700000, TO_DATE('2022-02-18', 'YYYY-MM-DD'), 1);
INSERT INTO EMPLOYEES (EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_ID) VALUES (106, '�ű��', 2900000, TO_DATE('2024-05-13', 'YYYY-MM-DD'), 3);
INSERT INTO EMPLOYEES (EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_ID) VALUES (107, '����Ŭ', 3300000, TO_DATE('2024-07-23', 'YYYY-MM-DD'), 3);
INSERT INTO EMPLOYEES (EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_ID) VALUES (108, '���ڹ�', 3900000, TO_DATE('2025-01-06', 'YYYY-MM-DD'), 3);
--------------------------------------------------------------------------------------------------------

-- ��� ������ �̸��� �޿��� ��ȸ
   select emp_name, salary from employees;

-- ����� ��� �� : 6

-- '�繫��'�� ���� �������� �̸��� �μ����� ��ȸ (����Ŭ ���� ���� ���)
/*
    EMP_NAME    | DEPT_NAME
    -----------------------
    ��ö��       | �繫��
    ������       | �繫��
*/

select emp_name, dept_name from employees e, departments d
where e.dept_id = d.dept_id and dept_name = '�繫��';


-- ��� �޿��� ��� (�Ҽ��� 2�ڸ����� ǥ��)
/*
    ��� �޿�
    ----------
    3766666.67
*/
select avg(salary) from employees;



-- �μ��� ���� ���� ����ϰ�, ���� ���� 3�� �̻��� �μ��� ��ȸ 
/*
    �μ���     | ���� ��
    -----------------------
    IT�μ�     | 4
*/
select dept_name, count(*) from employees e, departments d
where e.dept_id = d.dept_id
group by d.dept_name
having count(*) >= 3;

-- �޿��� ���� ���� ������ �̸��� �޿��� ��ȸ
/*
    ���� �̸�      | �޿�
    --------------------------
    �ֹ�ȣ	      | 4700000
*/
select emp_name, salary from employees
where salary = (select max(salary) from employees);

-- ���ο� ���̺� PROJECTS�� ���� 
--  ( ���� ����: ������Ʈ��ȣ (PROJECT_ID:NUMBER (PK), ������Ʈ�� (PROJECT_NAME:VARCHAR2(100) NULL ���X)))

create table PROJECTS(
     PROJECT_ID NUMBER PRIMARY KEY,
     PROJECT_NAME VARCHAR2(100) NOT NULL
);

comment on column PROJECTS.PROJECT_ID IS '������Ʈ��ȣ';
comment on column PROJECTS.PROJECT_NAME IS '������Ʈ��';

-- ���ο� ���� '�����'�� EMPLOYEES ���̺� ���� ( ���� ����: �޿� 3500000, IT�μ�, ���� �Ի�)
-- * ���� ��ȣ�� ���, �������� �����Ͽ� Ȱ���غ���. 

CREATE SEQUENCE EMP_SEQ
START WITH 109
NOCYCLE
NOCACHE;

INSERT INTO EMPLOYEES VALUES (EMP_SEQ.NEXTVAL,'�����',3500000,SYSDATE,3);
UPDATE EMPLOYEES SET EMP_ID = 109 WHERE EMP_NAME ='�����';

-- EMPLOYEES ���̺��� 'ȫ�浿'�� �޿��� 3800000���� ����

UPDATE EMPLOYEES SET SALARY = 3800000 WHERE EMP_NAME = 'ȫ�浿';

-- EMPLOYEES ���̺��� �޿��� 3000000 ������ �������� ���� -- 1�� �� ����

DELETE FROM EMPLOYEES WHERE SALARY <= 3000000;


-- EMPLOYEES ���̺� ���ο� �÷� EMAIL�� �߰� (VARCHAR2(100), �⺻�� 'temp@kh.or.kr')

ALTER TABLE EMPLOYEES ADD EMAIL VARCHAR2(100) DEFAULT 'temp@kh.or.kr';

-- ��� ������ �̸��� �޿��� �����ϴ� �� VW_EMP�� ����
-- * VIEW ���� ���� �ο� (������ ����)

grant create view to C##TESET250317;

create view vw_emp as (
   select emp_name, salary 
   from employees
);


-- ������ VIEW�� �������� �̸��� '��'�� ���Ե� ���� ��ȸ
/*
    �̸�   | �޿�
    �ֹ�ȣ	4700000
    �����	3500000
*/

select * from vw_emp where emp_name like '%��%';

-- �� VW_EMP�� ����

 drop view vw_emp;

-- EMPLOYEES ���̺��� ����

drop table employees;

----------------------------------------------------------------
-- * QUIZ1 * --------
/*
	CREATE USER C##TEST IDENTIFIED BY 1234; ����
	User C##TEST��(��) �����Ǿ����ϴ�.
	���� ������ �ϰ� ���� �� ���� (user C##TEST lacks CREATE SESSION privillege; logon denied ����)
*/

-- ���� ?      ������ ����� ������ ��� ���� ����
-- �ذ��� ?  �����ڰ������� 1) grant session to C##TEST  2) commit�� �Է��Ͽ� �������ش�

-- * QUIZ2 * --------
CREATE TABLE TB_JOB (
	JOBCODE NUMBER PRIMARY KEY,
	JOBNAME VARCHAR2(10) NOT NULL
);

CREATE TABLE TB_EMP (
	EMPNO NUMBER PRIMARY KEY,
	EMPNAME VARCHAR2(10) NOT NULL,
	JOBNO NUMBER REFERENCES TB_JOB(JOBCODE)
);
/*
	���� �� ���̺��� �����Ͽ� EMPNO, EMPNAME, JOBNO, JOBNAME �÷��� ��ȸ�ϰ��� �Ѵ�.
	�̶� ������ SQL���� �Ʒ��� ���ٰ� ���� ��,
  
*/
select * from tb_job 
join tb_emp on jobname = jobno;





SELECT EMPNO, EMPNAME, JOBNO, JOBNAME
FROM TB_EMP
	JOIN TB_JOB USING(JOBNO);
-- ������ ���� ������ �߻��ߴ�.
-- ORA-00904: "TB_JOB"."JOBNO": invalid identifier

-- ���� ?      ansi �������� �ۼ��� using�� �����̺��� �Ȱ��� �÷����� ���� ��� ����ϴµ� 
--              �����̺� �Ȱ��� �÷����� ����
-- �ذ��� ? using(jobno)�� on jobno = jobname���� �����Ѵ�.