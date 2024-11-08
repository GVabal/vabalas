FROM node:20.18.0-alpine3.20 as build
WORKDIR /app
COPY package.json ./
RUN npm config set package-lock false
RUN npm i
COPY . .
RUN npm run build

FROM nginx:latest
COPY --from=build app/dist/web /usr/share/nginx/html
EXPOSE 80
