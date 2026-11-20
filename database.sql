--
-- PostgreSQL database dump
--

\restrict LWeCDIKBFP3bgjfrysFzlbXQKUTqMsY4Bw7uNvLVACIRoBshwAmieJg8zHYM7dW

-- Dumped from database version 18.4
-- Dumped by pg_dump version 18.4

-- Started on 2026-11-21 00:53:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 227 (class 1259 OID 16539)
-- Name: addexercise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.addexercise (
    id integer NOT NULL,
    name character varying(200),
    category character varying(150),
    setsreps character varying(150)
);


ALTER TABLE public.addexercise OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16538)
-- Name: addexercise_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.addexercise_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.addexercise_id_seq OWNER TO postgres;

--
-- TOC entry 5054 (class 0 OID 0)
-- Dependencies: 226
-- Name: addexercise_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.addexercise_id_seq OWNED BY public.addexercise.id;


--
-- TOC entry 223 (class 1259 OID 16505)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
    admin_id integer NOT NULL,
    name character varying(200),
    email character varying(250),
    password character varying(250)
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16523)
-- Name: exercisecategory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exercisecategory (
    id integer NOT NULL,
    name character varying(200)
);


ALTER TABLE public.exercisecategory OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16522)
-- Name: exercisecategory_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exercisecategory_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.exercisecategory_id_seq OWNER TO postgres;

--
-- TOC entry 5055 (class 0 OID 0)
-- Dependencies: 224
-- Name: exercisecategory_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exercisecategory_id_seq OWNED BY public.exercisecategory.id;


--
-- TOC entry 220 (class 1259 OID 16447)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    name character varying(200),
    email character varying(250),
    password character varying(100),
    age integer,
    gender character varying(100),
    height integer,
    weight integer
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16446)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_user_id_seq OWNER TO postgres;

--
-- TOC entry 5056 (class 0 OID 0)
-- Dependencies: 219
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- TOC entry 222 (class 1259 OID 16457)
-- Name: workout; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.workout (
    workout_id integer NOT NULL,
    user_id integer,
    workout_date date DEFAULT CURRENT_DATE,
    exercise_id integer
);


ALTER TABLE public.workout OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16456)
-- Name: workout_workout_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.workout_workout_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.workout_workout_id_seq OWNER TO postgres;

--
-- TOC entry 5057 (class 0 OID 0)
-- Dependencies: 221
-- Name: workout_workout_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.workout_workout_id_seq OWNED BY public.workout.workout_id;


--
-- TOC entry 4879 (class 2604 OID 16542)
-- Name: addexercise id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.addexercise ALTER COLUMN id SET DEFAULT nextval('public.addexercise_id_seq'::regclass);


--
-- TOC entry 4878 (class 2604 OID 16526)
-- Name: exercisecategory id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercisecategory ALTER COLUMN id SET DEFAULT nextval('public.exercisecategory_id_seq'::regclass);


--
-- TOC entry 4875 (class 2604 OID 16450)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- TOC entry 4876 (class 2604 OID 16460)
-- Name: workout workout_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.workout ALTER COLUMN workout_id SET DEFAULT nextval('public.workout_workout_id_seq'::regclass);


--
-- TOC entry 5048 (class 0 OID 16539)
-- Dependencies: 227
-- Data for Name: addexercise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.addexercise (id, name, category, setsreps) FROM stdin;
2	Push-Ups	Push	3sets * 15reps
3	Pull-Ups	Pull	10reps * 3Sets
4	Squats	Leg	20Reps * 4Sets
5	Skipping	Cardio	Max * 3Sets
6	Bench Press	Push	3 sets * 10 reps
7	Shoulder Press	Push	3 sets * 10 reps
8	Dips	Push	3 sets * 12 reps
9	Incline Push-ups	Push	3 sets * 12 reps
10	Triceps Extensions	Push	3 sets * 12 reps
11	Bent-Over Row	Pull	3 sets * 10 reps
12	Biceps Curls	Pull	3 sets * 12 reps
13	Face Pulls	Pull	3 sets * 15 reps
14	Lunges	Leg	3 sets * 12 reps
15	Calf Raises	Leg	4 sets * 15 reps
16	Glute Bridge	Leg	3 sets * 15 reps
17	Wall Sit	Leg	3 sets * 45 sec
18	Jumping Jacks	Cardio	3 sets * 12 reps
19	Burpees	Cardio	3 sets * 12 reps
20	High knees	Cardio	3 sets * 40 sec
21	Mountain climbers	Cardio	3 sets * 30 sec
22	Runnig  	Cardio	15 - 20 min
\.


--
-- TOC entry 5044 (class 0 OID 16505)
-- Dependencies: 223
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin (admin_id, name, email, password) FROM stdin;
1	Vishal Singh	vishal2405.mcmt@gmail.com	admin123
\.


--
-- TOC entry 5046 (class 0 OID 16523)
-- Dependencies: 225
-- Data for Name: exercisecategory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exercisecategory (id, name) FROM stdin;
1	Push
2	Pull
3	Leg
4	Cardio
\.


--
-- TOC entry 5041 (class 0 OID 16447)
-- Dependencies: 220
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, name, email, password, age, gender, height, weight) FROM stdin;
11	Vishal Singh	vishal@gmail.com	123456	23	Gender	\N	\N
12	Admin	admin@gmail.com	1234	23	Gender	\N	\N
13	Rahul SIngh	Rahul123@gmail.com	rahul	24	Gender	\N	\N
16	Rahul Singh	rahul@gmail.com	1234	23	Male	165	65
14	Vishal Singh	vishal123@gmail.com	1234	24	Male	170	70
18	Xyz	xyz@gmail.com	123	23	Male	\N	\N
17	Ragnee	ragnee@gmail.com	123456	26	Female	170	50
\.


--
-- TOC entry 5043 (class 0 OID 16457)
-- Dependencies: 222
-- Data for Name: workout; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.workout (workout_id, user_id, workout_date, exercise_id) FROM stdin;
1	11	2026-10-30	8
2	11	2026-10-30	9
3	11	2026-10-30	10
4	11	2026-10-30	7
5	11	2026-10-30	6
6	11	2026-10-30	13
7	11	2026-10-30	12
8	11	2026-10-30	3
9	11	2026-10-30	11
10	11	2026-10-30	6
11	11	2026-10-30	7
12	11	2026-10-30	2
13	11	2026-10-30	9
14	11	2026-10-30	10
15	11	2026-10-30	2
16	11	2026-10-30	10
17	11	2026-10-30	9
18	11	2026-10-30	6
19	11	2026-10-30	7
20	11	2026-10-31	17
21	11	2026-10-31	15
22	11	2026-10-31	4
23	11	2026-10-31	16
24	11	2026-10-31	14
\.


--
-- TOC entry 5058 (class 0 OID 0)
-- Dependencies: 226
-- Name: addexercise_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.addexercise_id_seq', 22, true);


--
-- TOC entry 5059 (class 0 OID 0)
-- Dependencies: 224
-- Name: exercisecategory_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exercisecategory_id_seq', 4, true);


--
-- TOC entry 5060 (class 0 OID 0)
-- Dependencies: 219
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 18, true);


--
-- TOC entry 5061 (class 0 OID 0)
-- Dependencies: 221
-- Name: workout_workout_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.workout_workout_id_seq', 24, true);


--
-- TOC entry 4890 (class 2606 OID 16547)
-- Name: addexercise addexercise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.addexercise
    ADD CONSTRAINT addexercise_pkey PRIMARY KEY (id);


--
-- TOC entry 4886 (class 2606 OID 16512)
-- Name: admin admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (admin_id);


--
-- TOC entry 4888 (class 2606 OID 16529)
-- Name: exercisecategory exercisecategory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercisecategory
    ADD CONSTRAINT exercisecategory_pkey PRIMARY KEY (id);


--
-- TOC entry 4882 (class 2606 OID 16455)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 4884 (class 2606 OID 16463)
-- Name: workout workout_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.workout
    ADD CONSTRAINT workout_pkey PRIMARY KEY (workout_id);


--
-- TOC entry 4880 (class 1259 OID 16549)
-- Name: users_email_lower_uq; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX users_email_lower_uq ON public.users USING btree (lower((email)::text));


--
-- TOC entry 4891 (class 2606 OID 16464)
-- Name: workout fk_user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.workout
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 4892 (class 2606 OID 16550)
-- Name: workout workout_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.workout
    ADD CONSTRAINT workout_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.addexercise(id);


-- Completed on 2026-11-21 00:53:03

--
-- PostgreSQL database dump complete
--

\unrestrict LWeCDIKBFP3bgjfrysFzlbXQKUTqMsY4Bw7uNvLVACIRoBshwAmieJg8zHYM7dW

