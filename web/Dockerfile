FROM node:20.18.0-alpine3.20 as build
WORKDIR /app/src
COPY package.json ./
RUN npm config set package-lock false
RUN npm i
COPY . ./
RUN npm run build

FROM nginx:latest
WORKDIR /usr/share/nginx/html
COPY --from=build /app/src/dist/web ./
EXPOSE 80
